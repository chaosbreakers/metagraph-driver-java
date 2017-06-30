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


import io.metagraph.driver.traversal.KuazGraphTraversalSource;
import org.apache.tinkerpop.gremlin.structure.Graph;
import org.junit.Test;

import java.io.*;

/**
 * @author Ranger Tsao(https://github.com/boliza)
 */
public class MgitGraphTest {

    @Test
    public void traversal() throws Exception {
        Graph graph = Metagraph.connect(new MetagraphOptions()).get("cj4i5jnsm0000qo76vc3ostrq");
        KuazGraphTraversalSource g = (KuazGraphTraversalSource) graph.traversal().withComputer();
        //写文件
        byte[] newFile = getBytesFormFile("D:\\move\\del\\file\\1.txt");
        g.addV().addFile(newFile).next();
        //读文件
        g.V("cj4jb4ryb0001w403rxgdkldu").readFile().next();
    }

    @Test
    public void testGremlinDriver() {
        try {
            /*Cluster cluster = Cluster.build().addContactPoint("localhost").port(8182).create();
            Graph graph = EmptyGraph.instance();
            GraphTraversalSource g = graph.traversal().withRemote(DriverRemoteConnection.using(cluster, "metagraph"));

            KuazGraphTraversalSource mft = new KuazGraphTraversalSource(g);
            //写文件
            //byte[] newFile = getBytesFormFile("d:\\1.txt");
            File newFile = new File("d:\\1.txt");
            FileInputStream fis = new FileInputStream(newFile);*/
           /* mft.addFile(fis).next();
            //读文件
            byte[] file = (byte[]) mft.readFile().value().next();*/
            //saveFileToDisk(file, "d:\\", "3.txt");

            //g.V().valueMap(true);
            //System.out.println("test---"+ g.V().count().next().longValue());
            //g.addV("test").next();
            //g.close();
            //cluster.close();

            //g.V().addFile(newFile).next();
            //g.V().properties().
            //g.V().addFile(newFile).next();
            //g.V().addFile(newFile).next();
            //g.addV().addFile(newFile).next();
            //g.V().hasFile().next();
           /* byte[] file = (byte[])
            saveFileToDisk(file, "d:\\", "D:\\move\\del\\file\\3.txt");*/
                //g.addV().property("test","123").next();
                //FileInputStream fis = new FileInputStream("d:\\1.txt");
                //g.V().saveFile(fis);
            /*g.saveFile(newFile).next();
            g.*/
                //FileInputStream fis = new FileInputStream("d:\\1.txt");
                //ObjectInputStream in=new ObjectInputStream(fis);
                //mft.addFile(in).next();
                //读文件
            /*byte[] file = (byte[]) mft.readFile().value().next();
            saveFileToDisk(file, "d:\\", "3.txt");
            assertEquals(6L, gts.V().count().next().longValue());*/

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
        } catch (Exception e) {
            e.printStackTrace();
        }
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