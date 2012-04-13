package com.wordnik.client

import com.wordnik.client.ApiInvoker
import com.wordnik.client.ApiException

import java.util.Date
import com.wordnik.client.model.Definition
import com.wordnik.client.model.ContentProvider
import com.wordnik.client.model.Example
import com.wordnik.client.model.WordObject
import com.wordnik.client.model.WordOfTheDay
import com.wordnik.client.model.WordFrequency
import scala.collection.mutable.HashMap

class WordsApi {
  var basePath: String = "http://api.wordnik.com/v4"
  var apiInvoker = ApiInvoker

  def searchWords (query: String, includePartOfSpeech: String, excludePartOfSpeech: String, caseSensitive: String= "true", minCorpusCount: Int= 5, maxCorpusCount: Int= -1, minDictionaryCount: Int= 1, maxDictionaryCount: Int= -1, minLength: Int= 1, maxLength: Int= -1, skip: Int= 0, limit: Int= 10) : Option[List[WordFrequency]]= {
    // create path and map variables
    val path = "/words.{format}/search".replaceAll("\\{format\\}","json")// query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]

    // verify required params are set
    (Set(query) - null).size match {
       case 1 => // all required values set
       case _ => throw new Exception("missing required params")
    }
    if(String.valueOf(query) != "null") queryParams += "query" -> query.toString
    if(String.valueOf(caseSensitive) != "null") queryParams += "caseSensitive" -> caseSensitive.toString
    if(String.valueOf(includePartOfSpeech) != "null") queryParams += "includePartOfSpeech" -> includePartOfSpeech.toString
    if(String.valueOf(excludePartOfSpeech) != "null") queryParams += "excludePartOfSpeech" -> excludePartOfSpeech.toString
    if(String.valueOf(minCorpusCount) != "null") queryParams += "minCorpusCount" -> minCorpusCount.toString
    if(String.valueOf(maxCorpusCount) != "null") queryParams += "maxCorpusCount" -> maxCorpusCount.toString
    if(String.valueOf(minDictionaryCount) != "null") queryParams += "minDictionaryCount" -> minDictionaryCount.toString
    if(String.valueOf(maxDictionaryCount) != "null") queryParams += "maxDictionaryCount" -> maxDictionaryCount.toString
    if(String.valueOf(minLength) != "null") queryParams += "minLength" -> minLength.toString
    if(String.valueOf(maxLength) != "null") queryParams += "maxLength" -> maxLength.toString
    if(String.valueOf(skip) != "null") queryParams += "skip" -> skip.toString
    if(String.valueOf(limit) != "null") queryParams += "limit" -> limit.toString
    try {
      apiInvoker.invokeApi(basePath, path, "GET", queryParams.toMap, None, headerParams.toMap) match {
        case s: String =>
          Some(ApiInvoker.deserialize(s, "List", classOf[WordFrequency]).asInstanceOf[List[WordFrequency]])
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  def getWordOfTheDay (date: String) : Option[WordOfTheDay]= {
    // create path and map variables
    val path = "/words.{format}/wordOfTheDay".replaceAll("\\{format\\}","json")// query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]

    if(String.valueOf(date) != "null") queryParams += "date" -> date.toString
    try {
      apiInvoker.invokeApi(basePath, path, "GET", queryParams.toMap, None, headerParams.toMap) match {
        case s: String =>
          Some(ApiInvoker.deserialize(s, "", classOf[WordOfTheDay]).asInstanceOf[WordOfTheDay])
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  def getRandomWords (hasDictionaryDef: String, includePartOfSpeech: String, excludePartOfSpeech: String, sortBy: String, sortOrder: String, minCorpusCount: Int= 0, maxCorpusCount: Int= -1, minDictionaryCount: Int= 1, maxDictionaryCount: Int= -1, minLength: Int= 1, maxLength: Int= -1, limit: Int= 1000) : Option[List[WordObject]]= {
    // create path and map variables
    val path = "/words.{format}/randomWords".replaceAll("\\{format\\}","json")// query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]

    if(String.valueOf(hasDictionaryDef) != "null") queryParams += "hasDictionaryDef" -> hasDictionaryDef.toString
    if(String.valueOf(includePartOfSpeech) != "null") queryParams += "includePartOfSpeech" -> includePartOfSpeech.toString
    if(String.valueOf(excludePartOfSpeech) != "null") queryParams += "excludePartOfSpeech" -> excludePartOfSpeech.toString
    if(String.valueOf(minCorpusCount) != "null") queryParams += "minCorpusCount" -> minCorpusCount.toString
    if(String.valueOf(maxCorpusCount) != "null") queryParams += "maxCorpusCount" -> maxCorpusCount.toString
    if(String.valueOf(minDictionaryCount) != "null") queryParams += "minDictionaryCount" -> minDictionaryCount.toString
    if(String.valueOf(maxDictionaryCount) != "null") queryParams += "maxDictionaryCount" -> maxDictionaryCount.toString
    if(String.valueOf(minLength) != "null") queryParams += "minLength" -> minLength.toString
    if(String.valueOf(maxLength) != "null") queryParams += "maxLength" -> maxLength.toString
    if(String.valueOf(sortBy) != "null") queryParams += "sortBy" -> sortBy.toString
    if(String.valueOf(sortOrder) != "null") queryParams += "sortOrder" -> sortOrder.toString
    if(String.valueOf(limit) != "null") queryParams += "limit" -> limit.toString
    try {
      apiInvoker.invokeApi(basePath, path, "GET", queryParams.toMap, None, headerParams.toMap) match {
        case s: String =>
          Some(ApiInvoker.deserialize(s, "List", classOf[WordObject]).asInstanceOf[List[WordObject]])
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  def getRandomWord (includePartOfSpeech: String, excludePartOfSpeech: String, hasDictionaryDef: String= "true", minCorpusCount: Int= 0, maxCorpusCount: Int= -1, minDictionaryCount: Int= 0, maxDictionaryCount: Int= -1, minLength: Int= 0, maxLength: Int= -1) : Option[WordObject]= {
    // create path and map variables
    val path = "/words.{format}/randomWord".replaceAll("\\{format\\}","json")// query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]

    if(String.valueOf(hasDictionaryDef) != "null") queryParams += "hasDictionaryDef" -> hasDictionaryDef.toString
    if(String.valueOf(includePartOfSpeech) != "null") queryParams += "includePartOfSpeech" -> includePartOfSpeech.toString
    if(String.valueOf(excludePartOfSpeech) != "null") queryParams += "excludePartOfSpeech" -> excludePartOfSpeech.toString
    if(String.valueOf(minCorpusCount) != "null") queryParams += "minCorpusCount" -> minCorpusCount.toString
    if(String.valueOf(maxCorpusCount) != "null") queryParams += "maxCorpusCount" -> maxCorpusCount.toString
    if(String.valueOf(minDictionaryCount) != "null") queryParams += "minDictionaryCount" -> minDictionaryCount.toString
    if(String.valueOf(maxDictionaryCount) != "null") queryParams += "maxDictionaryCount" -> maxDictionaryCount.toString
    if(String.valueOf(minLength) != "null") queryParams += "minLength" -> minLength.toString
    if(String.valueOf(maxLength) != "null") queryParams += "maxLength" -> maxLength.toString
    try {
      apiInvoker.invokeApi(basePath, path, "GET", queryParams.toMap, None, headerParams.toMap) match {
        case s: String =>
          Some(ApiInvoker.deserialize(s, "", classOf[WordObject]).asInstanceOf[WordObject])
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  }
