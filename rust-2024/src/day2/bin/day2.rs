use std::fs;

type Report = Vec<u32>;

fn main() {
    let input: String = fs::read_to_string("src/day2/bin/input").unwrap();

    let reports: Vec<Report> = input
        .lines()
        .map(|line| {
            line.split_whitespace()
                .map(|level| level.parse::<u32>().unwrap())
                .collect()
        })
        .collect();

    let safe_count1: u32 = reports
        .iter()
        .filter(|report| report_is_safe(report, false))
        .count() as u32;

    let safe_count2: u32 = reports
        .iter()
        .filter(|report| report_is_safe(report, true))
        .count() as u32;

    println!("P1: {}", safe_count1);
    println!("P2: {}", safe_count2);
}

fn report_is_safe(report: &Report, remove_level: bool) -> bool {
    if report[0] == report[1] {
        return dampen(report, remove_level);
    }

    let descending: bool = report[0] > report[1];

    let range = 1..=3;

    for i in 0..report.len() - 1 {
        let left = report[i];
        let right = report[i + 1];

        let actual_descending = match left.cmp(&right) {
            std::cmp::Ordering::Less => false,
            std::cmp::Ordering::Greater => true,
            std::cmp::Ordering::Equal => return dampen(report, remove_level),
        };

        if descending != actual_descending {
            return dampen(report, remove_level);
        }

        let diff = left.abs_diff(right);
        if !range.contains(&diff) {
            return dampen(report, remove_level);
        }
    }

    true
}

fn dampen(report: &Report, remove_level: bool) -> bool {
    if remove_level {
        for i in 0..report.len() {
            let mut left = report.clone();
            left.remove(i);
            if report_is_safe(&left, false) {
                return true;
            }
        }
    }

    false
}
