 protected int getLRUCapacity(String prop){  String capacity = repository.getProperties().get(prop); return capacity == null ? 0 : Integer.valueOf(capacity);   } 
