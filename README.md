# Getting Started

## First Time

1. Clone the repo:

```sh
git clone git@github.com:PratikBhusal/dynamodblocal-kotest-intellij-plugin-bug.git
```

2. Download and install IntelliJ IDEA.

3. Install the official kotest intelliJ plugin. Try one of the
   following commands in the terminal:

```sh
open -na "IntelliJ IDEA.app" --args installPlugins kotest-plugin-intellij
idea installPlugins kotest-plugin-intellij
```

See: https://www.jetbrains.com/help/idea/managing-plugins.html#-6tvlrz_74


4. Verify gradle is working by running:

```sh
gradle clean build
```

5. Within IntelliJ IDEA, try to run the entire `LibraryTest : FunSpec`. All
   tests should pass without an engine exception.

6. Within IntelliJ IDEA, try to run a singular test leaf named
   `someLibraryMethod returns true`. See it fail with an error message that
   looks like the following engine exception:

```
Hello! Starting DynamoDB Project
Start Init server
io.kotest.engine.extensions.ExtensionException$BeforeProjectException: java.lang.NoSuchMethodError: 'java.lang.ClassLoader[] org.apache.logging.log4j.util.LoaderUtil.getClassLoaders()'
    at io.kotest.engine.project.ProjectExtensions.beforeProject(ProjectExtensions.kt:21)
    at io.kotest.engine.project.ProjectExtensions$beforeProject$1.invokeSuspend(ProjectExtensions.kt)
    at kotlin.coroutines.jvm.internal.BaseContinuationImpl.resumeWith(ContinuationImpl.kt:33)
    at kotlinx.coroutines.DispatchedTask.run(DispatchedTask.kt:106)
    at kotlinx.coroutines.EventLoopImplBase.processNextEvent(EventLoop.common.kt:280)
    at kotlinx.coroutines.BlockingCoroutine.joinBlocking(Builders.kt:85)
    at kotlinx.coroutines.BuildersKt__BuildersKt.runBlocking(Builders.kt:59)
    at kotlinx.coroutines.BuildersKt.runBlocking(Unknown Source)
    at kotlinx.coroutines.BuildersKt__BuildersKt.runBlocking$default(Builders.kt:38)
    at kotlinx.coroutines.BuildersKt.runBlocking$default(Unknown Source)
    at io.kotest.common.RunBlockingKt.runBlocking(runBlocking.kt:3)
    at io.kotest.engine.launcher.MainKt.main(main.kt:34)
Caused by: java.lang.NoSuchMethodError: 'java.lang.ClassLoader[] org.apache.logging.log4j.util.LoaderUtil.getClassLoaders()'
    at org.apache.logging.log4j.core.impl.ThreadContextDataInjector.getServiceProviders(ThreadContextDataInjector.java:83)
    at org.apache.logging.log4j.core.impl.ThreadContextDataInjector.initServiceProviders(ThreadContextDataInjector.java:73)
    at org.apache.logging.log4j.core.impl.ThreadContextDataInjector.getProviders(ThreadContextDataInjector.java:285)
    at org.apache.logging.log4j.core.impl.ThreadContextDataInjector.access$000(ThreadContextDataInjector.java:55)
    at org.apache.logging.log4j.core.impl.ThreadContextDataInjector$ForCopyOnWriteThreadContextMap.<init>(ThreadContextDataInjector.java:226)
    at org.apache.logging.log4j.core.impl.ContextDataInjectorFactory.createDefaultInjector(ContextDataInjectorFactory.java:94)
    at org.apache.logging.log4j.core.impl.ContextDataInjectorFactory.createInjector(ContextDataInjectorFactory.java:71)
    at org.apache.logging.log4j.core.impl.ReusableLogEventFactory.<init>(ReusableLogEventFactory.java:42)
    at org.apache.logging.log4j.core.config.LoggerConfig.<clinit>(LoggerConfig.java:96)
    at org.apache.logging.log4j.core.config.AbstractConfiguration.<init>(AbstractConfiguration.java:136)
    at org.apache.logging.log4j.core.config.NullConfiguration.<init>(NullConfiguration.java:32)
    at org.apache.logging.log4j.core.LoggerContext.<clinit>(LoggerContext.java:85)
    at org.apache.logging.log4j.core.selector.ClassLoaderContextSelector.createContext(ClassLoaderContextSelector.java:254)
    at org.apache.logging.log4j.core.selector.ClassLoaderContextSelector.locateContext(ClassLoaderContextSelector.java:218)
    at org.apache.logging.log4j.core.selector.ClassLoaderContextSelector.getContext(ClassLoaderContextSelector.java:136)
    at org.apache.logging.log4j.core.selector.ClassLoaderContextSelector.getContext(ClassLoaderContextSelector.java:123)
    at org.apache.logging.log4j.core.selector.ClassLoaderContextSelector.getContext(ClassLoaderContextSelector.java:117)
    at org.apache.logging.log4j.core.impl.Log4jContextFactory.getContext(Log4jContextFactory.java:150)
    at org.apache.logging.log4j.core.impl.Log4jContextFactory.getContext(Log4jContextFactory.java:47)
    at org.apache.logging.log4j.LogManager.getContext(LogManager.java:197)
    at org.apache.logging.log4j.LogManager.getLogger(LogManager.java:611)
    at com.amazonaws.services.dynamodbv2.local.shared.logging.LogManager.getLogger(LogManager.java:49)
    at com.amazonaws.services.dynamodbv2.local.main.ServerRunner.<clinit>(ServerRunner.java:40)
    at org.example.testing.extension.DynamoDbLocalClientExtension.beforeProject(DynamoDbLocalClientExtension.kt:37)
    at org.example.testing.extension.DynamoDbLocalClientExtension$beforeProject$1.invokeSuspend(DynamoDbLocalClientExtension.kt)
    ... 10 more

java.lang.NoSuchMethodError: 'java.lang.ClassLoader[] org.apache.logging.log4j.util.LoaderUtil.getClassLoaders()'

Process finished with exit code 255
```
