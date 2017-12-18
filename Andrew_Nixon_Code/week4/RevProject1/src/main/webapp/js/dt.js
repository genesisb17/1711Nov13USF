var data = [
    {
        "name":       "Tiger Nixon",
        "position":   "System Architect",
        "salary":     "$3,120",
        "start_date": "2011/04/25",
        "office":     "Edinburgh",
        "extn":       "5421"
    },
    {
        "name":       "Garrett Winters",
        "position":   "Director",
        "salary":     "$5,300",
        "start_date": "2011/07/25",
        "office":     "Edinburgh",
        "extn":       "8422"
    }
]

//[{"reimbID":42,"amount":666.0,"submitted":1513218510409,"resolved":null,"description":null,"receipt":null,"author":63,"resolver":0,"statusID":24,"typeID":21}];//,{"reimbID":43,"amount":999.0,"submitted":1513395874873,"resolved":null,"description":"test"}];//,"description":null,"receipt":null,"author":63,"resolver":0,"statusID":24,"typeID":21}];
var data4 = [{"reimbID":42,"amount":666.0,"submitted":1513218510409,"resolved":null,"description":null,"receipt":null,"author":63,"resolver":0,"statusID":24,"typeID":21},{"reimbID":43,"amount":999.0,"submitted":1513395874873,"resolved":null,"description":"test","receipt":null,"author":63,"resolver":0,"statusID":24,"typeID":21}];
	//[{"reimbID":42,"amount":666.0,"submitted":1513218510409,"resolved":null,"description":null,"receipt":null,"author":63,"resolver":0,"statusID":24,"typeID":21},{"reimbID":43,"amount":999.0,"submitted":1513395874873,"resolved":null,"description":"test","receipt":null,"author":63,"resolver":0,"statusID":24,"typeID":21}];

$(document).ready( function () {
    $('#table_id').DataTable();
    $('#table_id2').DataTable( {
        data: data,
        columns: [
            { data: 'name' },
            { data: 'position' },
            { data: 'salary' },
            { data: 'office' }
        ]
    } );
    var data3 = [{"reimbID":41,"resolved":null,"amount":2112.0,"submitted":1513217723863,"description":"test1","statusID":21,"typeID":21}];
    $('#table_id3').DataTable( {
    	data: data3,
        columns: [
            { data: 'reimbID' },
            { data: 'resolved' },
            { data: 'amount' },
            { data: 'submitted' },
            { data: 'description' },
            { data: 'statusID' },
            { data: 'typeID' }
        ]
    } );
    var table4 = $('#table_id4').DataTable( {
    	//data: data3,
        columns: [
            { data: 'reimbID' },
            { data: 'amount' },
            { data: 'submitted' },
            { data: 'resolved' },
            { data: 'description' },
            { data: 'receipt' },
            { data: 'author' },
            { data: 'resolver'},
            { data: 'statusID' },
            { data: 'typeID' }
        ]
    });

	table4.rows.add( data4 ).draw();
} );