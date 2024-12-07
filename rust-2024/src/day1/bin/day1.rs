use std::fs;

fn main() {
    let f = fs::read_to_string("src/day1/bin/input").unwrap();
    let mut left_list: Vec<u32> = vec![];
    let mut right_list: Vec<u32> = vec![];

    for line in f.lines() {
        left_list.push(line.split_once("   ").unwrap().0.parse().unwrap());
        right_list.push(line.split_once("   ").unwrap().1.parse().unwrap());
    }

    left_list.sort();
    right_list.sort();

    let mut distances = 0;
    let mut similarity = 0;
    for (index, element) in left_list.iter().enumerate() {
        distances += element.abs_diff(right_list[index]);

        let count = right_list.iter().filter(|&v| v == element).count();
        similarity += element * count as u32;
    }

    // part1
    println!("{}", distances);
    // part2
    println!("{}", similarity);
}
