  IAction action = ((ActionContributionItem) item).getAction(); if (action.getStyle() == IAction.AS_DROP_DOWN_MENU) {  MOpaqueToolItem toolItem = MenuFactoryImpl.eINSTANCE.createOpaqueToolItem();  toolItem.setElementId(item.getId());  container.getChildren().add(toolItem);  renderer.linkModelToContribution(toolItem, item); 				} else { } }
