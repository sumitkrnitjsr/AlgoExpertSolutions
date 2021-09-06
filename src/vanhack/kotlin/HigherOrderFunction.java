package vanhack.kotlin;

/*
A partial function is a function that accepts as parameters:
an argument of some type.
a function whose first parameter is of that same type.
The partial function returns another function, very similar to the source function. The returned function has the same return type and its params are (almost) all the same.
The only difference is that, for this function, you don’t need to provide the first parameter that was required by the source function.
Here's an example with source functions with two parameters:
fun add(x: Int, y: Int) = x + y
val addTo5 = partial(5, ::add)
val result = addTo5(3) // 8
fun repeat(times: Int, str: String) = str.repeat(times)
val sayTwice = partial(2, ::repeat)
val callForLunch = sayTwice("Let's have lunch! ") // Let's have lunch! Let's have lunch!
fun join(str1: String, str2: String, str3: String) = "$str1 $str2 $str3"
val helloTo = partial("Hello,", ::join)
val johnEmail = partial("John.", helloTo)
val inviteForAChatEmail = johnEmail("Let's grab a coffee sometime!") // Hello, John. Let's grab a coffee sometime!
val inviteForALunchEmail = johnEmail("Can we go lunch together tomorrow?") // Hello, John. Can we go lunch together tomorrow?
val fireEmail = johnEmail("You are fired!") // Hello, John. You are fired!
*/

public class HigherOrderFunction {
	fun<T, V> partial(num: T,operation : (T, V) -> V): (V) -> V{    
	    return {s: V -> operation(num, s) }
	}

	fun<T, U, V> partial(num: T,operation : (T, U, V) -> V): (U, V) -> V{    
	    return {s1: U,s2: V  -> operation(num, s1, s2) }
	}
	
	
}
