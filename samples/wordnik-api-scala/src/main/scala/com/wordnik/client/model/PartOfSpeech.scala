package com.wordnik.client.model

import scala.reflect.BeanProperty

class PartOfSpeech {
  @BeanProperty var value: String = _

  override def toString: String = {
    val sb = new StringBuilder
    sb.append("class PartOfSpeech {\n")
    sb.append("  value: ").append(value).append("\n")
    sb.append("}\n")
    sb.toString
  }
}

