package de.brainschweig.vocabulary.exceptions;

public class VocableNotFoundException extends RuntimeException {

  VocableNotFoundException(Integer id) {
    super("Could not find Vocable " + id);
  }
}