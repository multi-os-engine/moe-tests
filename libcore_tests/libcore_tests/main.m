#include <MOE/MOE.h>
#include <Foundation/Foundation.h>


int main(int argc, char *argv[]) {
#if TARGET_OS_IPHONE && !TARGET_IPHONE_SIMULATOR
    @autoreleasepool {
        // Try to add custom tmp dir
        NSArray *paths = NSSearchPathForDirectoriesInDomains(NSDocumentDirectory, NSUserDomainMask, YES);
        NSString *basePath = ([paths count] > 0) ? [[paths objectAtIndex:0] stringByAppendingPathComponent:@"tmp"] : nil;
        if (!basePath) {
            return moevm(argc, argv);
        }
        
        NSFileManager *fm = [NSFileManager defaultManager];
        [fm removeItemAtPath:basePath error:NULL];
        [fm createDirectoryAtPath:basePath withIntermediateDirectories:YES attributes:@{} error:NULL];
        char ** args = malloc(sizeof(char *) * (argc + 1));
        args[0] = argv[0];
        args[1] = strdup([NSString stringWithFormat:@"-Djava.io.tmpdir=%@", basePath].UTF8String);
        for (int i = 1; i < argc; ++i) {
            args[i + 1] = argv[i];
        }
        return moevm(argc + 1, args);
    }
#else
    return moevm(argc, argv);
#endif
}
