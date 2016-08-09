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

#include "C+Functions+Primitives.h"

#pragma mark - Functions with primitive types

bool NGBoolCreate(bool a) { return a; }
char NGByteCreate(char a) { return a; }
short NGShortCreate(short a) { return a; }
unichar NGCharCreate(unichar a) { return a; }
int NGIntCreate(int a) { return a; }
long long NGLongCreate(long long a) { return a; }
float NGFloatCreate(float a) { return a; }
double NGDoubleCreate(double a) { return a; }

bool NGBoolCompare(bool a, bool b) { return a == b; }
bool NGByteCompare(char a, char b) { return a == b; }
bool NGShortCompare(short a, short b) { return a == b; }
bool NGCharCompare(unichar a, unichar b) { return a == b; }
bool NGIntCompare(int a, int b) { return a == b; }
bool NGLongCompare(long long a, long long b) { return a == b; }
bool NGFloatCompare(float a, float b) { return a == b; }
bool NGDoubleCompare(double a, double b) { return a == b; }

#pragma mark - Functions with primitive* types

bool *NGBoolCreateArray(int count) { return malloc(count * sizeof(bool)); }
char *NGByteCreateArray(int count) { return malloc(count * sizeof(char)); }
short *NGShortCreateArray(int count) { return malloc(count * sizeof(short)); }
unichar *NGCharCreateArray(int count) { return malloc(count * sizeof(unichar)); }
int *NGIntCreateArray(int count) { return malloc(count * sizeof(int)); }
long long *NGLongCreateArray(int count) { return malloc(count * sizeof(long long)); }
float *NGFloatCreateArray(int count) { return malloc(count * sizeof(float)); }
double *NGDoubleCreateArray(int count) { return malloc(count * sizeof(double)); }

bool NGBoolArrayCompare(bool *a, bool *b, int count) { return memcmp(a, b, count * sizeof(bool)) == 0; }
bool NGByteArrayCompare(char *a, char *b, int count) { return memcmp(a, b, count * sizeof(char)) == 0; }
bool NGShortArrayCompare(short *a, short *b, int count) { return memcmp(a, b, count * sizeof(short)) == 0; }
bool NGCharArrayCompare(unichar *a, unichar *b, int count) { return memcmp(a, b, count * sizeof(unichar)) == 0; }
bool NGIntArrayCompare(int *a, int *b, int count) { return memcmp(a, b, count * sizeof(int)) == 0; }
bool NGLongArrayCompare(long long *a, long long *b, int count) { return memcmp(a, b, count * sizeof(long long)) == 0; }
bool NGFloatArrayCompare(float *a, float *b, int count) { return memcmp(a, b, count * sizeof(float)) == 0; }
bool NGDoubleArrayCompare(double *a, double *b, int count) { return memcmp(a, b, count * sizeof(double)) == 0; }

void NGBoolArrayFree(bool *a) { free(a); }
void NGByteArrayFree(char *a) { free(a); }
void NGShortArrayFree(short *a) { free(a); }
void NGCharArrayFree(unichar *a) { free(a); }
void NGIntArrayFree(int *a) { free(a); }
void NGLongArrayFree(long long *a) { free(a); }
void NGFloatArrayFree(float *a) { free(a); }
void NGDoubleArrayFree(double *a) { free(a); }

#pragma mark - Functions with primitive** types

bool **NGBoolCreateArrayRef(bool *array) { bool **ref = malloc(sizeof(bool*)); ref[0] = array; return ref; }
char **NGByteCreateArrayRef(char *array) { char **ref = malloc(sizeof(char*)); ref[0] = array; return ref; }
short **NGShortCreateArrayRef(short *array) { short **ref = malloc(sizeof(short*)); ref[0] = array; return ref; }
unichar **NGCharCreateArrayRef(unichar *array) { unichar **ref = malloc(sizeof(unichar*)); ref[0] = array; return ref; }
int **NGIntCreateArrayRef(int *array) { int **ref = malloc(sizeof(int*)); ref[0] = array; return ref; }
long long **NGLongCreateArrayRef(long long *array) { long long **ref = malloc(sizeof(long long*)); ref[0] = array; return ref; }
float **NGFloatCreateArrayRef(float *array) { float **ref = malloc(sizeof(float*)); ref[0] = array; return ref; }
double **NGDoubleCreateArrayRef(double *array) { double **ref = malloc(sizeof(double*)); ref[0] = array; return ref; }

bool NGBoolArrayRefCompare(bool **a, bool *b, int count) { return memcmp(a[0], b, count * sizeof(bool)) == 0; }
bool NGByteArrayRefCompare(char **a, char *b, int count) { return memcmp(a[0], b, count * sizeof(char)) == 0; }
bool NGShortArrayRefCompare(short **a, short *b, int count) { return memcmp(a[0], b, count * sizeof(short)) == 0; }
bool NGCharArrayRefCompare(unichar **a, unichar *b, int count) { return memcmp(a[0], b, count * sizeof(unichar)) == 0; }
bool NGIntArrayRefCompare(int **a, int *b, int count) { return memcmp(a[0], b, count * sizeof(int)) == 0; }
bool NGLongArrayRefCompare(long long **a, long long *b, int count) { return memcmp(a[0], b, count * sizeof(long long)) == 0; }
bool NGFloatArrayRefCompare(float **a, float *b, int count) { return memcmp(a[0], b, count * sizeof(float)) == 0; }
bool NGDoubleArrayRefCompare(double **a, double *b, int count) { return memcmp(a[0], b, count * sizeof(double)) == 0; }

void NGBoolArrayRefFree(bool **a) { free(a); }
void NGByteArrayRefFree(char **a) { free(a); }
void NGShortArrayRefFree(short **a) { free(a); }
void NGCharArrayRefFree(unichar **a) { free(a); }
void NGIntArrayRefFree(int **a) { free(a); }
void NGLongArrayRefFree(long long **a) { free(a); }
void NGFloatArrayRefFree(float **a) { free(a); }
void NGDoubleArrayRefFree(double **a) { free(a); }
