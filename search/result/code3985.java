  break; case SWT.ARROW_UP:  next = goUp(group, pos, hCount);  break;  case SWT.ARROW_DOWN:  next = goDown(group, pos, hCount);  break;  case SWT.PAGE_UP:  next = goUp(group, pos, hCount 						* Math.max(maxVisibleRows - 1, 1));  break;  case SWT.PAGE_DOWN:  next = goDown(group, pos, hCount  * Math.max(maxVisibleRows - 1, 1));  break; 			} 		} else {  int vCount = ((Integer) group.getData(V_COUNT)).intValue();  int maxVisibleColumns = gallery.getClientArea().width / itemWidth;  switch (key) {  case SWT.ARROW_LEFT:  next = goUp(group, pos, vCount); }
