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

import java.util.Arrays;
import java.util.Map;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toUnmodifiableMap;
import academy.devonline.javamm.code.component.ExpressionContext;
import academy.devonline.javamm.code.fragment.Expression;

/**
 * @author Alex
 * @link http://healthfood.net.ua
 */
public enum TypeExpression implements Expression {

    INTEGER(Integer.class),

    STRING(String.class),

    BOOLEAN(Boolean.class),

    DOUBLE(Double.class);

    // TODO Array

    private static final Map<String, TypeExpression> ALL_TYPES = Arrays
        .stream(TypeExpression.values())
        .collect(toUnmodifiableMap(TypeExpression::getKeyword, identity()));

    private final Class<?> clazz;

    TypeExpression(final Class<?> clazz) {
        this.clazz = clazz;
    }

    public static boolean is(final String keyword) {
        return ALL_TYPES.containsKey(keyword);
    }

    public static TypeExpression of(final String keyword) {
        final TypeExpression typeExpression = ALL_TYPES.get(keyword);
        if (typeExpression != null) {
            return typeExpression;
        } else {
            throw new IllegalArgumentException("Unsupported type: " + keyword);
        }
    }

    public String getKeyword() {
        return name().toLowerCase();
    }

    @Override
    public Object getValue(final ExpressionContext expressionContext) {
        return this;
    }

    public Class<?> getType() {
        return clazz;
    }

    @Override
    public String toString() {
        return getKeyword();
    }
}
