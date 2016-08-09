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

#include "Common_Defines.h"

#define TEST_METHOD_DIRECT(name)                                   \
MOE_EXTERN bool test##name##sWithPairNumber(uint32_t n, ...);

#define TEST_METHOD(name) \
TEST_METHOD_DIRECT(name)

TEST_METHOD(Boolean)
TEST_METHOD(Byte)
TEST_METHOD(Char)
TEST_METHOD(Short)
TEST_METHOD(Int)
TEST_METHOD(Long)
TEST_METHOD(Float)
TEST_METHOD(Double)

TEST_METHOD(CGRect)
TEST_METHOD(CString)

TEST_METHOD(NFloat)
TEST_METHOD(NUInt)
TEST_METHOD(NInt)

#undef TEST_METHOD_DIRECT
#undef TEST_METHOD_BLOCK
#undef TEST_METHOD
