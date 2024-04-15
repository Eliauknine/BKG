  link(s1a, bo1);  link(s2a, bo2);  pes = linkService.getPictogramElements(d, boList, true);  assertFalse(pes.isEmpty());  assertEquals(s1a, pes.get(0)); }
