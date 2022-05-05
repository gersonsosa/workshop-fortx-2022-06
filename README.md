# How the right architecture helps you make big changes

During the workshop, this repo will be updated with code that you will be working on.

## Assignments

Go to [part-01/README.md](part-01/README.md) for the first exercises.

## Workshop preparation

**TLDR:** Install IntelliJ + clone repo + check that tests run.

There are a few things you can do to make sure you have a running start and don't lose any time on basic setup during
the workshop.

### Install the latest IntelliJ IDEA

The [free IntelliJ Community edition](https://www.jetbrains.com/idea/download/) is sufficient for this workshop.

If you already have IntelliJ Community or Ultimate installed, that is fine, but do make sure you update it to a recent
version.
The easiest way to manage your IntelliJ installation is using the [Toolbox App](https://www.jetbrains.com/toolbox-app/).

### Clone this repo

You can do this directly from IntelliJ using `File`, `New`, `Project from Version Control...`, and entering the url
which you can find under the `Code` button on the GitHub page.

### Validate your setup

After opening the project, IntelliJ will need some time to sync the gradle project, download dependencies and compile
the code. At this point, you may run into some of the issues mentioned below.

Once the gradle build is complete, let's make sure you can run the tests.

Run all the tests. Press `Ctrl + Alt + R` (Mac) or `Alt + Shift + F10` (Win),
then select `Tests in 'part-01'` and press enter.

If all is well, the test should fail with `expected: <Hello kotlin> but was: <Hello world>`

Now open `Hello.kt` and fix the code. Run the tests again to make sure they pass.

### Common issues

Common issues that you may run into:

- Missing `JDK 17`. To resolve this, go to `Project Structure` using `Cmd + ;` (Mac). Go to `SDKs`, click on the `+` and
  download a Java 17 SDK, for example `Eclipse Temurin`.
- Missing `JUnit 5`. Sometimes IntelliJ complains about this. Click the IntelliJ hint to add JUnit 5.

## Tip: Test often

Once you have validated that the tests are running, get into the habit of running the tests regularly by
pressing `Ctrl + R`. That will re-run the last run configuration you used.

During the workshop, run the test often, pretty much after any small change you make. That way you get quick feedback
when you break the code unintentionally, and you don't lose time continuing on broken code.

Also, don't run individual tests. Always run the complete suite - it's fast enough and that way you don't miss out on
any potential feedback.

## Get familiar with Kotlin

The techniques covered during the workshop are not tied to any specific programming language. You will likely be able to
apply them in any typed programming language like Java, C#, C++ or TypeScript.

The small codebase you will be given for this workshop is written in Kotlin. If you have some experience with Java, C#
or TypeScript it should be easy to pick up Kotlin. If you have not worked with Kotlin before, don't worry! We'll do a
mini-kotlin-crash-course at the start of the workshop. As preparation, you can get familiar with the Kotlin basics by
going through a few of the [Kotlin Koans online](https://play.kotlinlang.org/koans/).

Tip: the Koans run tests to validate your solution, in some cases it can be insightful to take a peek at
the [sourcecode for those tests](https://github.com/Kotlin/kotlin-koans/tree/master/test) to understand what is going
on.
