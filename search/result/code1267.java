 pr_ModuleDef returns [List<Definition> definitions]{ (	(	m = pr_Visibility { modifier = $m.modifier; }	)? 	(	d1 = pr_TypeDef { if($d1.def_type != null) { $definitions.add($d1.def_type); } } 	|	d2 = pr_ConstDef { if($d2.array != null) { $definitions.addAll($d2.array); } } 	|	d3 = pr_TemplateDef { if($d3.def_template != null) { $definitions.add($d3.def_template); } } 	|	d4 = pr_FunctionDef { if($d4.def_func != null) { $definitions.add($d4.def_func); } } 	|	d5 = pr_SignatureDef { if($d5.def_type != null) { $definitions.add($d5.def_type); } } 	|	d6 = pr_TestcaseDef { if($d6.def_testcase != null) { $definitions.add($d6.def_testcase); } } } 
