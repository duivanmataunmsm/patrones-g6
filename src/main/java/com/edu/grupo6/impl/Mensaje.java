package com.edu.grupo6.impl;

import java.time.LocalDateTime;

public class Mensaje {
  private String content;
  private LocalDateTime _createdAt = LocalDateTime.now();

  public Mensaje(String content) {
    this.content = content;
  }

  public LocalDateTime getCreatedAt() {
    return _createdAt;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getContent() {
    return content;
  }

}
