function matchPassword()
{
    if(document.getElementById('rpassword').value!=document.getElementById('password').value)
    {
	  alert("Confirm password does not match with password")
	  return false;
    }
    return true;
}
