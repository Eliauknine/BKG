    } @Subscribe  public void onEvent(SnippetRepositoryChangedEvent e) throws IOException {  close();  open();     }  public static class SnippetRepositoryChangedEvent {     
