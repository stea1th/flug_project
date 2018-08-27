
$(document).ready(function(){
    $("#customerForm").submit(function (event) {
        event.preventDefault();
        ajaxPost();
    });

    function ajaxPost(){
        var formData = $("#filename").val();

        $.ajax({
            type : "POST",
            contentType : "text/plain",
            url : window.location + "/upload",
            data : formData,
            dataType : 'text',
            success : function (result) {
                if(result === "Done"){
                    $("#postResultDiv").html("<p style='background-color:#7FA7B0; color:white; padding:20px 20px 20px 20px'>" +
                        "Saved Successfully! <br>" +
                        "---> FileName's Info: Filename = " +
                        formData  + "</p>");
                }else if(result === "Error"){
                    $("#postResultDiv").html("<p style='background-color:#b05f53; color:white; padding:20px 20px 20px 20px'>" +
                        "Data Type Error <br>" +
                        "---> File "+formData+" is corrupt/ not .XLS-format!</p>");
                }else if(result === "Null"){
                    $("#postResultDiv").html("<p style='background-color:#b05f53; color:white; padding:20px 20px 20px 20px'>" +
                        "Data Saving Error <br>" +
                        "---> File: "+formData+" is already saved!</p>");
                }else if(result === "Format"){
                    $("#postResultDiv").html("<p style='background-color:#b05f53; color:white; padding:20px 20px 20px 20px'>" +
                        "Data Saving Error <br>" +
                        "---> File: "+formData+" has invalid format!</p>");
                }
                console.log(result)
            },
            error : function(e) {
                alert("Error!");
                console.log("ERROR: ", e);
            }

        });
        resetData();
    }

    function resetData() {
        $("#filename").val("");
    }
})