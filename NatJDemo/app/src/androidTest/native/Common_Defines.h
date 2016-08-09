#include <stdbool.h>
#include <stdlib.h>

typedef unsigned short unichar;
typedef bool BOOL;

#if     __LP64__
#define CGFloat double
#define NSUInteger unsigned long long
#define NSInteger signed long long
#else
#define CGFloat float
#define NSUInteger unsigned int
#define NSInteger signed int
#endif

typedef struct {
    CGFloat x;
    CGFloat y;
} CGPoint;

typedef struct {
    CGFloat width;
    CGFloat height;
} CGSize;

typedef struct {
    CGPoint point;
    CGSize size;
} CGRect;

#define MOE_EXTERN extern __attribute__((visibility ("default")))
