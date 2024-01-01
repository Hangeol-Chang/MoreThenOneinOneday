use std::io::{stdin, Read};

fn main() {
    // println!("Hello, world!");
    let mut input = String::new();
    stdin().read_to_string(&mut input).unwrap();
    let mut input = input.split_ascii_whitespace().flat_map(str::parse::<usize>);

    let a1 = input.next().unwrap();
    let b1 = input.next().unwrap();
    let c1 = input.next().unwrap();

    let a2 = input.next().unwrap();
    let b2 = input.next().unwrap();
    let c2 = input.next().unwrap();

    let s1 = a1 * 3 + b1 * 2 + c1 * 1;
    let s2 = a2 * 3 + b2 * 2 + c2 * 1;

    if s1 > s2 {
        println!("A");
    } else if s1 < s2 {
        println!("B");
    }
    else {
        println!("T");
    }
}