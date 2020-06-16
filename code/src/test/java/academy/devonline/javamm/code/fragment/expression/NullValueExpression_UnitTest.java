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

package academy.devonline.javamm.code.fragment.expression;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import academy.devonline.javamm.code.component.ExpressionContext;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * @author Alex
 * @link http://healthfood.net.ua
 */
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
class NullValueExpression_UnitTest {

    @Mock
    private ExpressionContext expressionContext;

    @Test
    @Order(1)
    void getInstance_should_return_singleton_instance() {
        assertSame(NullValueExpression.getInstance(), NullValueExpression.getInstance());
    }

    @Test
    @Order(2)
    void getValue_should_return_null_without_interaction_with_expressionContext() {
        final NullValueExpression nullValueExpression = NullValueExpression.getInstance();

        assertNull(nullValueExpression.getValue(expressionContext));
        verify(expressionContext, never()).getValue(any());
    }

    @Test
    @Order(3)
    void toString_should_return_null_string() {
        assertEquals("null", NullValueExpression.getInstance().toString());
    }


}