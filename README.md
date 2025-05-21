# SI_2025_lab2_233179

Jordan Todorovski 233179

2.CFG (Grafot) graf.jpg
3.Ciklomatskata kompleksnost se presmetuva kako c=p+1(7+1). Vo nasiot slucaj e 8.
4.Vkupno ke ni trebaat 5 test case-ovi za da gi proverime site statements. Pocetniot test case  e listata da e null za da dobieme exception, posle toa imame item shto nema da e imenuvan za da frli exception, posle toa imame skap item za dodavanje na popust i posledniot e prazna lista od items i tocna kartica.
Statement allItems = null, cardNumber = "123" | allitems=[("",100,0,1)], cardNumber=1234567891234567 | allitems=[("exp",350,0,1)], cardNumber=1234567891234567 | allitems=[("ime",100,0,1)], cardNumber=123 | allitems=[], cardNumber=1234567891234567 1 ✓ ✓ ✓ ✓ ✓ 2 ✓ 3 ✓ ✓ ✓ ✓ 4 ✓ ✓ ✓ ✓ 5 ✓ ✓ ✓ 6 ✓ ✓ ✓ 7 ✓ 8 ✓ ✓ 9 ✓ 10 ✓ ✓ 11 12 ✓ ✓ 13 ✓ ✓ ✓ 14 ✓ ✓ 15 ✓ ✓ 16 ✓ ✓ 17 ✓ ✓ 18 ✓ ✓ 19 20 ✓ 21 ✓ ✓
5. Za Multiple Condition kriteriumot(if (item.getPrice() > 300 || item.getDiscount() > 0 || item.getQuantity() > 10)) bi ni bile potrebni 4 test case-ovi, za da gi opfatime FFF,TXX,XTX,XXT ili 350.0.0 ; 350.10.0 ; 350,0,120 ; 250,-10,-10
