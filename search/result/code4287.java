  itr = fBeanModel.getBeans().iterator() ; while (itr.hasNext()) {  if (isDown(pm))  return ;		 		  	  BeanPart bean = (BeanPart) itr.next() ;  bean.getBadExpressions().clear(); } }
