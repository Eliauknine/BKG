  delegate.open(); delegateOpen = true;  openJob = null;  return Status.OK_STATUS;                         } catch (IOException e) {  LOG.error("Exception while opening repository.", e); }
