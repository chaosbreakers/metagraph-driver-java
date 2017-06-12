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

import org.junit.Test;

/**
 * @author Ranger Tsao(https://github.com/boliza)
 */
public class MetagraphImplTest {

    @Test
    public void list() throws Exception {
    }

    @Test
    public void get() throws Exception {
        MetagraphImpl metagraph = new MetagraphImpl(new MetagraphOptions());
        metagraph.get("metagraph");
    }

    @Test
    public void create() throws Exception {
    }

    @Test
    public void update() throws Exception {
    }

    @Test
    public void delete() throws Exception {
    }

}