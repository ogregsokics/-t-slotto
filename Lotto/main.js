    function katt() {
        
            $.ajax({
                url:"NewServlet",
                type:"POST",
                data:{"task":"inditas"},
                success:function(){ 
                }, 
                error:function(){
                }
            });
             getResults();         
    }
            
    function percent() {

         document.getElementById("percent").innerHTML = "";

         $.ajax({
                url:"NewServlet",
                type:"POST",
                data:{"task":"percent"},
                success:function(rd){ 

                    for (var i = 0; i < rd.length; i++) {

                        var table4 = document.getElementById("percent");
                        var row1 = table4.insertRow();

                        var cell0 = row1.insertCell();
                        var cell1 = row1.insertCell();

                        cell0.innerHTML = i + " találatos szelvények aránya:";
                        cell1.innerHTML = rd[i].percent + " %";
                    }
                }, 
                error:function(){
                }
                });
    }

    function deleteAll() {

         $.ajax({
                url:"NewServlet",
                type:"POST",
                data:{"task":"delete"},
                success:function(){ 
                }, 
                error:function(){
                }
        });

        document.getElementById("percent").innerHTML = "";
        document.getElementById("table1").innerHTML = "";
        document.getElementById("table2").innerHTML = "";
        document.getElementById("table3").innerHTML = "";

        }


        function getResults() {

             $.ajax({
                url:"NewServlet",
                type:"POST",
                data:{"task":"getresults"},
                success:function(rd){ 

                    document.getElementById("percent").innerHTML = "";
                    document.getElementById("table1").innerHTML = "";
                    document.getElementById("table2").innerHTML = "";
                    document.getElementById("table3").innerHTML = "";


                    for (var i = 0; i < rd.length; i++) {


                        var a1 = rd[i].sorsolt.split(",");
                        var a2 = rd[i].tippek.split(",");
                        var a3 = rd[i].talalatok;

                        var table1 = document.getElementById("table1");
                        var table2 = document.getElementById("table2");
                        var table3 = document.getElementById("table3");



                        var row1 = table1.insertRow();
                        
                        row1.id = "sorsolt" + rd.length;
                        
                        var cell0 = row1.insertCell(0);
                        var cell1 = row1.insertCell(1);
                        var cell2 = row1.insertCell(2);
                        var cell3 = row1.insertCell(3);
                        var cell4 = row1.insertCell(4);

                        cell0.innerHTML = a1[0];
                        cell1.innerHTML = a1[1];
                        cell2.innerHTML = a1[2];
                        cell3.innerHTML = a1[3];
                        cell4.innerHTML = a1[4];

                        var cellt  = [cell0, cell1, cell2, cell3, cell4];

                        var a4 = rd[i].elsosor;

                        if (a4.length==1) {
                            var ez = a4;
                            cellt[ez].style.backgroundColor = "green";
                        }

                        if (a4.length>2) {

                            var a4t = a4.split(",");
                            for (var k = 0; k < a4t.length; k++) {
                                var az;
                                az = a4t[k];
                                cellt[az].style.backgroundColor = "green";
                            }
                        }



                        var row2 = table2.insertRow();
                        
                        row2.id = "tippek" + rd.length;

                        var cell6 = row2.insertCell(0);
                        var cell7 = row2.insertCell(1);
                        var cell8 = row2.insertCell(2);
                        var cell9 = row2.insertCell(3);
                        var cell10 = row2.insertCell(4);

                        cell6.innerHTML = a2[0];
                        cell7.innerHTML = a2[1];
                        cell8.innerHTML = a2[2];
                        cell9.innerHTML = a2[3];
                        cell10.innerHTML = a2[4]; 

                        var cellt2  = [cell6, cell7, cell8, cell9, cell10];     

                        var a5 = rd[i].masodiksor;

                        if (a5.length==1) {
                            var ez = a5;
                            cellt2[ez].style.backgroundColor = "green";
                        }

                        if (a5.length>2) {
                             var a5t = a5.split(",");
                             for (var k = 0; k < a5t.length; k++) {
                                 var az;
                                 az = a5t[k];
                                 cellt2[az].style.backgroundColor = "green";
                             }
                        }



                        var row3 = table3.insertRow();
                        
                        
                        
                        row3.id = "talalatok" + i;
                        var cell11 = row3.insertCell(0);

                        if (a3.length == 0) {

                          cell11.innerHTML = "NINCS TALÁLAT!"; 
                          document.getElementById("talalatok" + i).style.backgroundColor = "red";
                        }
                        if (a3.length > 0) {
                            document.getElementById("talalatok" + i).style.backgroundColor = "#00ff99";
                            cell11.innerHTML = a3;
                        }
                        
                        
                        document.getElementById("sorsolt" + rd.length).style.borderStyle  = "solid";
                        document.getElementById("tippek" + rd.length).style.borderStyle  = "solid";
                        document.getElementById("talalatok" + 0).style.borderStyle  = "solid";
                        
                        document.getElementById("sorsolt" + rd.length).style.borderColor  = "white";
                        document.getElementById("tippek" + rd.length).style.borderColor  = "white";
                        document.getElementById("talalatok" + 0).style.borderColor  = "white";
                        
                        document.getElementById("sorsolt" + rd.length).style.borderWidth = "thick";
                        document.getElementById("tippek" + rd.length).style.borderWidth = "thick";
                        document.getElementById("talalatok" + 0).style.borderWidth = "thick";

                    }    
                }, 
                error:function(){
                    alert("hiba a küldés/fogadás során");
                }
            });
        }

