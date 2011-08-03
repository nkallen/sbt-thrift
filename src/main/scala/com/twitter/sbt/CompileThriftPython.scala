package com.twitter.sbt

import _root_.sbt._

trait CompileThriftPython extends CompileThrift {
  lazy val compileThriftPython = compileThriftAction("py:new_style")

  lazy val autoCompileThriftPython = task {
    if (autoCompileThriftEnabled) {
      compileThriftPython.run
    } else {
      log.info("%s: not auto-compiling thrift-python; you may need to run compile-thrift-python manually".format(name))
      None
    }
  }

  override def compileAction = super.compileAction dependsOn(autoCompileThriftPython)
}

trait CompileThriftPythonTwisted extends CompileThrift {
  lazy val compileThriftPythonTwisted = compileThriftAction("py:new_style,twisted")

  lazy val autoCompileThriftPython = task {
    if (autoCompileThriftEnabled) {
      compileThriftPython.run
    } else {
      log.info("%s: not auto-compiling thrift-python; you may need to run compile-thrift-python manually".format(name))
      None
    }
  }

  override def compileAction = super.compileAction dependsOn(autoCompileThriftPythonTwisted)
}
