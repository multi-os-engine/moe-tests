/*
 * Copyright (C) 2014 Intel Corporation
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
#include "Structs.h"

#pragma mark - Functions with small struct types

MOE_EXTERN NG_I_Struct NGIStructCreate(int x, int y);
MOE_EXTERN bool NGIStructCompare(NG_I_Struct value, int x, int y);

#pragma mark - Functions with small struct* types

MOE_EXTERN NG_I_Struct *NGIStructCreatePtr(NG_I_Struct value);
MOE_EXTERN bool NGIStructRefCompare(NG_I_Struct *value, int x, int y);
MOE_EXTERN void NGIStructRefFree(NG_I_Struct *value);

#pragma mark - Functions with large struct types

MOE_EXTERN NG_ISMulti_Struct NGISMultiStructCreate(int x, int y);
MOE_EXTERN int NGISMultiStructFind(NG_ISMulti_Struct value, int x, int y);

#pragma mark - Functions with large struct* types

MOE_EXTERN NG_ISMulti_Struct *NGISMultiStructCreatePtr(int x, int y);
MOE_EXTERN void NGISMultiStructRefFree(NG_ISMulti_Struct *value);
