  options.put(XMLResource.OPTION_ENCODING, initialObjectCreationPage.getEncoding()); resource.save(options); 					} catch (Exception exception) {  DocumentstructuretemplateEditorPlugin.INSTANCE.log(exception); 					} finally {  progressMonitor.done(); 					}
