
function simple()
{
    function hello()
    {
        console.log("hello man");

    }
    
    function vanakkam()
    {
        hello();
    }
    return vanakkam;
}
simple()();

