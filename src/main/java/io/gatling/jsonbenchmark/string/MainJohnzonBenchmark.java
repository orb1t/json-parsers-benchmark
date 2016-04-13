/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package io.gatling.jsonbenchmark.string;

import java.io.StringReader;
import java.util.concurrent.TimeUnit;

import javax.json.JsonReader;
import javax.json.spi.JsonProvider;
import org.apache.johnzon.core.JsonProviderImpl;
import org.openjdk.jmh.annotations.GenerateMicroBenchmark;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.logic.BlackHole;
import static io.gatling.jsonbenchmark.bytes.Buffers.STR_ACTION_LABEL_BYTES;
import static io.gatling.jsonbenchmark.bytes.Buffers.STR_CITM_CATALOG_BYTES;
import static io.gatling.jsonbenchmark.bytes.Buffers.STR_MEDIUM_BYTES;
import static io.gatling.jsonbenchmark.bytes.Buffers.STR_MENU_BYTES;
import static io.gatling.jsonbenchmark.bytes.Buffers.STR_SGML_BYTES;
import static io.gatling.jsonbenchmark.bytes.Buffers.STR_SMALL_BYTES;
import static io.gatling.jsonbenchmark.bytes.Buffers.STR_WEBXML_BYTES;
import static io.gatling.jsonbenchmark.bytes.Buffers.STR_WIDGET_BYTES;

@State
public class MainJohnzonBenchmark {

    private JsonProvider jsonProvider = new JsonProviderImpl();

    private Object parse(String str) throws Exception {
        JsonReader reader = jsonProvider.createReader(new StringReader(str));
        try {
            return reader.read();
        }
        finally {
            reader.close();
        }
    }

    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void actionLabel(BlackHole bh) throws Exception {
        bh.consume(parse(STR_ACTION_LABEL_BYTES));
    }

    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void citmCatalog(BlackHole bh) throws Exception {
        bh.consume(parse(STR_CITM_CATALOG_BYTES));
    }

    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void medium(BlackHole bh) throws Exception {
        bh.consume(parse(STR_MEDIUM_BYTES));
    }

    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void menu(BlackHole bh) throws Exception {
        bh.consume(parse(STR_MENU_BYTES));
    }

    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void sgml(BlackHole bh) throws Exception {
        bh.consume(parse(STR_SGML_BYTES));
    }

    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void small(BlackHole bh) throws Exception {
        bh.consume(parse(STR_SMALL_BYTES));
    }

    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void webxml(BlackHole bh) throws Exception {
        bh.consume(parse(STR_WEBXML_BYTES));
    }

    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void widget(BlackHole bh) throws Exception {
        bh.consume(parse(STR_WIDGET_BYTES));
    }
}
