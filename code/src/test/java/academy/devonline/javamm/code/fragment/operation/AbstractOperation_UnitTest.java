/*
 *
 *  * Copyright (c) 2019. http://devonline.academy
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *     http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

package academy.devonline.javamm.code.fragment.operation;

import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import academy.devonline.javamm.code.fragment.SourceLine;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

/**
 * @author Alex
 * @link http://healthfood.net.ua
 */
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class AbstractOperation_UnitTest {

    @Test
    void toString_should_delegate_the_call_to_the_SourceLine_toString() {
        final SourceLine sourceLine = new SourceLine("module1", 1, List.of("var", "a", "=", "2"));
        assertEquals(sourceLine.toString(), new AbstractOperation(sourceLine) {
        }.toString());
    }

}