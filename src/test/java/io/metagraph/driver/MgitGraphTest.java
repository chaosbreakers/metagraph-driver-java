/*
 *
 *   Copyright (C) 2015-2017 Monogram Inc.
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package io.metagraph.driver;


import io.metagraph.driver.traversal.dsl.MetagraphFileTraversal;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource;
import org.apache.tinkerpop.gremlin.structure.Graph;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;

/**
 * @author Ranger Tsao(https://github.com/boliza)
 */
public class MgitGraphTest {

    @Test
    public void traversal() throws Exception {
        Graph graph = Metagraph.connect(new MetagraphOptions()).get("cj486u3i40003vc769qds4d0o");
        GraphTraversalSource gts = graph.traversal().withComputer();
        MetagraphFileTraversal mft = new MetagraphFileTraversal(gts);
        //写文件
        byte[] newFile = getBytesFormFile("d:\\1.txt");
        mft.addFile(newFile).next();
        //读文件
        byte[] file = (byte[]) mft.readFile().value().next();
        saveFileToDisk(file, "d:\\", "3.txt");
        assertEquals(6L, gts.V().count().next().longValue());

       /* GraphTraversalSource g = graph.traversal().withComputer();
        g.addV().property("name","marko").next();*/
        //g.addV().property("name","marko").next();
        //g.addV().addV()
        //byte[] fileBytes = getBytes("d:\\1.txt");
        //g.addV().property("file", fileBytes).next();
       /* byte[] storeFileBytes = (byte[])g.V().properties("file").value().next();
        getFile(storeFileBytes,"d:\\","2.txt");*/
        //assertEquals("marko", g.V().properties("name").value().next());
        //assertEquals(6L, g.V().count().next().longValue());

    }

    /**
     * 获得指定文件的byte数组
     */
    private byte[] getBytesFormFile(String filePath) {
        byte[] buffer = null;
        try {
            File file = new File(filePath);
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream(4096);
            byte[] b = new byte[4096];
            int n;
            while ((n = fis.read(b)) != -1) {
                bos.write(b, 0, n);
            }
            fis.close();
            bos.close();
            buffer = bos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer;
    }

    /**
     * 根据byte数组，生成文件
     */
    public static void saveFileToDisk(byte[] bfile, String filePath, String fileName) {
        BufferedOutputStream bos = null;
        FileOutputStream fos = null;
        File file = null;
        try {
            File dir = new File(filePath);
            if (!dir.exists() && dir.isDirectory()) {//判断文件目录是否存在
                dir.mkdirs();
            }
            file = new File(filePath + "\\" + fileName);
            fos = new FileOutputStream(file);
            bos = new BufferedOutputStream(fos);
            bos.write(bfile);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

}