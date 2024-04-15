 m_bundleURI = bundleURI;  }  public void startDownload(Shell parentShell) {  m_sdd = new RwtScoutDownloadDialog(parentShell, getURL());  m_sdd.open();   
