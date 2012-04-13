package com.wordnik.client.model;

public class Example {
  private long id = 0L;
  private String text = null;
  private String title = null;
  private String url = null;
  public long getId() {
    return id;
  }
  public void setId(long id) {
    this.id = id;
  }

  public String getText() {
    return text;
  }
  public void setText(String text) {
    this.text = text;
  }

  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }

  public String getUrl() {
    return url;
  }
  public void setUrl(String url) {
    this.url = url;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Example {\n");
    sb.append("  id: ").append(id).append("\n");
    sb.append("  text: ").append(text).append("\n");
    sb.append("  title: ").append(title).append("\n");
    sb.append("  url: ").append(url).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
