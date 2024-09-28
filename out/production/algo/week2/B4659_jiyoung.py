while True:
    pwd = input()
    if pwd == 'end':
        break

    is_valid = True  # 비밀번호의 유효성 판단하는 변수

    # 조건 1
    vowel = "aeiou"
    checkVowel = False  # '조건 1' 체크하는 변수

    for char in pwd:
        if char in vowel:
            checkVowel = True
            break

    # 조건 2
    vowels_count = 0  # 연속된 모음 수
    consonants_count = 0  # 연속된 자음 수

    for char in pwd:
        if char in vowel:  # 모음이면
            vowels_count += 1  # 모음 수 증가
            consonants_count = 0  # 모음이 나왔으므로 연속 자음 수 초기화
        else:  # 자음이면 (위에랑 반대로)
            consonants_count += 1
            vowels_count = 0

        if vowels_count == 3 or consonants_count == 3:
            is_valid = False
            break

    # 조건 3
    prev_char = ""
    for i in range(len(pwd)):
        now_char = pwd[i]  # 현재 문자

        if i > 0:
            prev_char = pwd[i - 1]

        if now_char == prev_char and now_char not in "eo":
            is_valid = False
            break

    # 결과 출력
    if checkVowel and is_valid:
        print(f"<{pwd}> is acceptable.")
    else:
        print(f"<{pwd}> is not acceptable.")
