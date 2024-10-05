import Foundation

func matchesPattern(_ pattern: String, in text: String) -> Bool {
    let regex = try! NSRegularExpression(pattern: pattern)
    let range = NSRange(location: 0, length: text.utf16.count)
    return regex.firstMatch(in: text, options: [], range: range) != nil
}

while let readln = readLine(), readln != "end" {
    let condition1 = matchesPattern("[aeiou]", in: readln)
    let condition2 = !matchesPattern("[aeiou]{3}|[^aeiou]{3}", in: readln)
    let condition3 = !matchesPattern("(.)\\1", in: readln) || matchesPattern("(ee|oo)", in: readln)
    
    if condition1, condition2, condition3 {
        print("<\(readln)> is acceptable.")
    } else {
        print("<\(readln)> is not acceptable.")
    }
}

// 백준에서는 Swift5.7을 지원하지 않아 Regex()을 찾을수 없다고 나온다.
/*while let readln = readLine(), readln != "end" {
    let condition1 = readln.contains(try! Regex("[aeiou]"))
    let condition2 = !readln.contains(try! Regex("[aeiou]{3}|[^aeiou]{3}"))
    let condition3 = !readln.contains(try! Regex("(.)\\1")) || readln.contains(try! Regex("(ee|oo)"))
    
    if condition1, condition2, condition3 {
        print("<\(readln)> is acceptable.")
    } else {
        print("<\(readln)> is not acceptable.")
    }
}*/
