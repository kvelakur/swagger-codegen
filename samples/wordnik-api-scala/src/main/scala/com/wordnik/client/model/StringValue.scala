package com.wordnik.client.model

import scala.reflect.BeanProperty

class StringValue {
  @BeanProperty var word: String = _
  override def toString: String = {
    val sb = new StringBuilder
    sb.append("class StringValue {\n")
    sb.append("  word: ").append(word).append("\n")
    sb.append("}\n")
    sb.toString
  }
}
