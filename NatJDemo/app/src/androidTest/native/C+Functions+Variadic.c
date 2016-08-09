/*
 * Copyright (C) 2015 Intel Corporation
 *
 * Licensed under the Eclipse Public License, Version 1.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.eclipse.org/org/documents/epl-v10.php
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

#include "C+Functions+Variadic.h"

#include <stdarg.h>

#define TEST_INNER(rtype, ptype, cmp)                   \
    va_list vl;                                         \
    va_start(vl, n);                                    \
                                                        \
    BOOL match = true;                                  \
    for (int i = 0; match && i < n; i++) {              \
        rtype _1 = va_arg(vl, ptype);                   \
        rtype _2 = va_arg(vl, ptype);                   \
        if (!(cmp)) {                                   \
            match = false;                              \
        }                                               \
    }                                                   \
                                                        \
    va_end(vl);                                         \
    return match;

#define TEST_METHOD_DIRECT(name, rtype, ptype, cmp) \
bool test##name##sWithPairNumber(uint32_t n, ...) { \
    TEST_INNER(rtype, ptype, cmp)                   \
}

#define TEST_METHOD(name, rtype, ptype, cmp)    \
TEST_METHOD_DIRECT(name, rtype, ptype, cmp)

TEST_METHOD(Boolean, uint8_t, uint32_t, _1 == _2)
TEST_METHOD(Byte, int8_t, int32_t, _1 == _2)
TEST_METHOD(Char, uint16_t, uint32_t, _1 == _2)
TEST_METHOD(Short, int16_t, int32_t, _1 == _2)
TEST_METHOD(Int, int32_t, int32_t, _1 == _2)
TEST_METHOD(Long, int64_t, int64_t, _1 == _2)
TEST_METHOD(Float, float, double, _1 == _2)
TEST_METHOD(Double, double, double, _1 == _2)

BOOL CGRectEqualToRect(CGRect a, CGRect b) {
    return (a.point.x == b.point.x) && (a.point.y == b.point.y) &&
            (a.size.width == b.size.width) && (a.size.height == b.size.height);
}

TEST_METHOD(CGRect, CGRect, CGRect, CGRectEqualToRect(_1, _2))
TEST_METHOD(CString, const char*, const char*, strcmp(_1, _2) == 0)

TEST_METHOD(NFloat, CGFloat, double, _1 == _2)
TEST_METHOD(NUInt, NSUInteger, NSUInteger, _1 == _2)
TEST_METHOD(NInt, NSInteger, NSInteger, _1 == _2)

#undef TEST_INNER
#undef TEST_METHOD_DIRECT
#undef TEST_METHOD_BLOCK
#undef TEST_METHOD
