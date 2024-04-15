    * @param node_p non-null diff node   */  protected void registerCategories(EMFDiffNode node_p) {  // Merge process, non-pending (already handled by the user)  IDifferenceCategorySet mergeCategorySet = new DifferenceCategorySet(  Messages.AbstractComparisonViewer_CatSetTextMerge,  Messages.AbstractComparisonViewer_CatSetDescriptionMerge);  mergeCategorySet.getChildren().add(new MergedDifferenceCategory());  mergeCategorySet.getChildren().add(new IgnoredDifferenceCategory());  // Basic two-way  IDifferenceCategorySet basicCategorySet = new DifferenceCategorySet(  Messages.AbstractComparisonViewer_CatSetTextBasic,  Messages.AbstractComparisonViewer_CatSetDescriptionBasic);  basicCategorySet.getChildren().add(new PropertyChangeCategory());  basicCategorySet.getChildren().add(new MoveCategory());  basicCategorySet.getChildren().add(new UnmatchedElementCategory(true));  basicCategorySet.getChildren().add(new UnmatchedElementCategory(false));  // Basic three-way  IDifferenceCategorySet threeWayCategorySet = new DifferenceCategorySet(  Messages.AbstractComparisonViewer_CatSetText3Way,  Messages.AbstractComparisonViewer_CatSetDescription3Way);  threeWayCategorySet.getChildren().add(new ThreeWayOriginCategory(true));  threeWayCategorySet.getChildren().add(new ThreeWayOriginCategory(false));  threeWayCategorySet.getChildren().add(new ConflictCategory());  // Registration  CategoryManager catManager = node_p.getCategoryManager();  catManager.addCategories(basicCategorySet);  catManager.addCategories(threeWayCategorySet);  catManager.addCategories(mergeCategorySet);   }  /** }
