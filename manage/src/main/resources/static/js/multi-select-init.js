$('#navigationSelect').multiSelect({
    afterSelect: function(values){
        alert("Select value: "+values);
    },
    afterDeselect: function(values){
        alert("Deselect value: "+values);
    }
});
$('#menuSelect').multiSelect({
    selectableOptgroup: true
});