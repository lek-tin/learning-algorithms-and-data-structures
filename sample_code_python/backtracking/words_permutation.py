def permute(words):
    result = []
    word_count = {}

    for word in words:
        word_count[word] = word_count.get(word, 0) + 1

    permute_helper(words, word_count, [], result)
    return result


# Time complexity: O(N!), N denotes the number of words
# Space complexity: O(N)
def permute_helper(words, word_count, current_permutation, result):
    if len(current_permutation) == len(words):
        result.append(current_permutation.copy())
        return

    for word, count in word_count.items():
        if count > 0:
            current_permutation.append(word)
            word_count[word] -= 1

            permute_helper(words, word_count, current_permutation, result)

            current_permutation.pop()
            word_count[word] += 1

# Example usage
words = ["apple", "orange", "pear", "apple"]

for permutation in permutations:
    print(permutation)
