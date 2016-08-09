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

#pragma mark - Functions with primitive types

MOE_EXTERN bool NGBoolCreate(bool a);
MOE_EXTERN char NGByteCreate(char a);
MOE_EXTERN short NGShortCreate(short a);
MOE_EXTERN unichar NGCharCreate(unichar a);
MOE_EXTERN int NGIntCreate(int a);
MOE_EXTERN long long NGLongCreate(long long a);
MOE_EXTERN float NGFloatCreate(float a);
MOE_EXTERN double NGDoubleCreate(double a);

MOE_EXTERN bool NGBoolCompare(bool a, bool b);
MOE_EXTERN bool NGByteCompare(char a, char b);
MOE_EXTERN bool NGShortCompare(short a, short b);
MOE_EXTERN bool NGCharCompare(unichar a, unichar b);
MOE_EXTERN bool NGIntCompare(int a, int b);
MOE_EXTERN bool NGLongCompare(long long a, long long b);
MOE_EXTERN bool NGFloatCompare(float a, float b);
MOE_EXTERN bool NGDoubleCompare(double a, double b);

#pragma mark - Functions with primitive* types

MOE_EXTERN bool *NGBoolCreateArray(int count);
MOE_EXTERN char *NGByteCreateArray(int count);
MOE_EXTERN short *NGShortCreateArray(int count);
MOE_EXTERN unichar *NGCharCreateArray(int count);
MOE_EXTERN int *NGIntCreateArray(int count);
MOE_EXTERN long long *NGLongCreateArray(int count);
MOE_EXTERN float *NGFloatCreateArray(int count);
MOE_EXTERN double *NGDoubleCreateArray(int count);

MOE_EXTERN bool NGBoolArrayCompare(bool *a, bool *b, int count);
MOE_EXTERN bool NGByteArrayCompare(char *a, char *b, int count);
MOE_EXTERN bool NGShortArrayCompare(short *a, short *b, int count);
MOE_EXTERN bool NGCharArrayCompare(unichar *a, unichar *b, int count);
MOE_EXTERN bool NGIntArrayCompare(int *a, int *b, int count);
MOE_EXTERN bool NGLongArrayCompare(long long *a, long long *b, int count);
MOE_EXTERN bool NGFloatArrayCompare(float *a, float *b, int count);
MOE_EXTERN bool NGDoubleArrayCompare(double *a, double *b, int count);

MOE_EXTERN void NGBoolArrayFree(bool *a);
MOE_EXTERN void NGByteArrayFree(char *a);
MOE_EXTERN void NGShortArrayFree(short *a);
MOE_EXTERN void NGCharArrayFree(unichar *a);
MOE_EXTERN void NGIntArrayFree(int *a);
MOE_EXTERN void NGLongArrayFree(long long *a);
MOE_EXTERN void NGFloatArrayFree(float *a);
MOE_EXTERN void NGDoubleArrayFree(double *a);

#pragma mark - Functions with primitive** types

MOE_EXTERN bool **NGBoolCreateArrayRef(bool *array);
MOE_EXTERN char **NGByteCreateArrayRef(char *array);
MOE_EXTERN short **NGShortCreateArrayRef(short *array);
MOE_EXTERN unichar **NGCharCreateArrayRef(unichar *array);
MOE_EXTERN int **NGIntCreateArrayRef(int *array);
MOE_EXTERN long long **NGLongCreateArrayRef(long long *array);
MOE_EXTERN float **NGFloatCreateArrayRef(float *array);
MOE_EXTERN double **NGDoubleCreateArrayRef(double *array);

MOE_EXTERN bool NGBoolArrayRefCompare(bool **a, bool *b, int count);
MOE_EXTERN bool NGByteArrayRefCompare(char **a, char *b, int count);
MOE_EXTERN bool NGShortArrayRefCompare(short **a, short *b, int count);
MOE_EXTERN bool NGCharArrayRefCompare(unichar **a, unichar *b, int count);
MOE_EXTERN bool NGIntArrayRefCompare(int **a, int *b, int count);
MOE_EXTERN bool NGLongArrayRefCompare(long long **a, long long *b, int count);
MOE_EXTERN bool NGFloatArrayRefCompare(float **a, float *b, int count);
MOE_EXTERN bool NGDoubleArrayRefCompare(double **a, double *b, int count);

MOE_EXTERN void NGBoolArrayRefFree(bool **a);
MOE_EXTERN void NGByteArrayRefFree(char **a);
MOE_EXTERN void NGShortArrayRefFree(short **a);
MOE_EXTERN void NGCharArrayRefFree(unichar **a);
MOE_EXTERN void NGIntArrayRefFree(int **a);
MOE_EXTERN void NGLongArrayRefFree(long long **a);
MOE_EXTERN void NGFloatArrayRefFree(float **a);
MOE_EXTERN void NGDoubleArrayRefFree(double **a);
