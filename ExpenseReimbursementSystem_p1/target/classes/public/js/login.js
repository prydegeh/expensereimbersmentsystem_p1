let form = document.getElementById("input-form");
form.addEventListener('submit', login);


async function login (e){
    e.preventDefault();

    let username = document.getElementById("username").value;
    let password = document.getElementById("password").value;

    let user = {
        username,
        password
    }

    

    let req = await fetch('http://localhost:7000/employees',{
        method: 'POST',
        headers: {
            'Content-Type':'application/json'
        },
        body: JSON.stringify(user)


    });
    //console.log(req)   ;
 
    let res = await req.json();

    console.log(res);

    if(res.code== 403){
        console.log(res.message);
        alert(res.message);
    }
    else{
	let usernameCheck = {
		username
	}
	
	let req = await fetch('http://localhost:7000/employees',{
        method: 'POST',
        headers: {
            'Content-Type':'application/json'
        },
        body: JSON.stringify(usernameCheck)


    });
    	
    	res = await req.json();
		if(res.userRole.id==1)
			location.href = 'google.com';	
		else
			location.href = 'google.com';	

	
	
	
}
       


}
