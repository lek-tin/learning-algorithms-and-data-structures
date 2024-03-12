import os

from typing import BinaryIO, Iterable, List, Tuple


def detect_duplicates() -> List[Iterable[str]]:
    """
    Determine which files located within the "images" directory are duplicates
    of each other.
    Example:
    ```
    for dirpath, dirnames, filenames in os.walk("images"):
        # do stuff
    ```
    See the os.walk() docs at https://docs.python.org/3/library/os.html#os.walk


    :returns: A list of duplicate groups. A duplicate group is a file with two or
        more copies represented by the paths to all the copies of the file.
        The order of the groups is unspecified.
    """
    groups = []
    imageMap = {} # key: image hash, value: list of filepaths
    for dirpath, dirnames, filenames in os.walk("images"):
        # print(dirpath)
        # print(dirnames)
        # print(filenames)
        for filename in filenames:
            filepath = os.path.join(dirpath, filename)
            print(filepath)
            with open(filepath,'rb') as fp:
                # two different hash valus mean two different files
                # two same has values != same files
                img_hash = _calculate_hash(fp)
                print(img_hash)
                if img_hash not in imageMap:
                    imageMap[img_hash] = []
                imageMap[img_hash].append(filepath)
                
        print("---")
        
    for key in imageMap.keys():
        filePaths = imageMap[key]
        groups.append(filePaths)
    
    print(groups)
    print("---")
    return groups
    
def _calculate_hash(fp: BinaryIO) -> str:
    """
    Calculate the hash of the file referenced by filename.

    Example usage:
    ```
    with open(file_path,'rb') as fp:
        img_hash = _calculate_hash(fp)
    ```

    :param fp: The file-like object to generate the hash for.
    :returns: A hexadecimal-encoded hash of the file referenced by filename.
    """
    # increase 100 -> 100,000 to reduce collision
    return sum(fp.read()) % 100000



###############################################################################
##
##   HERE BE DRAGONS!!!
##
##   You should not need to look at the code below. It serves as a scaffolding
##   to set up and call your code when `Run` is pushed and verify the results.
##
###############################################################################
##
##                                    ^    /^
##                                   / \  // \
##                     |\___/|      /   \//  .\
##                     /V  V  \__  /    //  | \ \           *----*
##                    /     /  \/_/    //   |  \  \          \   |
##                    @___@`    \/_   //    |   \   \         \/\ \
##                   0/0/|       \/_ //     |    \    \         \  \
##               0/0/0/0/|        \///      |     \     \       |  |
##            0/0/0/0/0/_|_ /   (  //       |      \     _\     |  /
##         0/0/0/0/0/0/`/,_ _ _/  ) ; -.    |    _ _\.-~       /   /
##                     ,-}        _      *-.|.-~-.           .~    ~
##   *     \__/         `/\      /                 ~-. _ .-~      /
##    \____(Oo)            *.   }            {                   /
##    (    (..)           .----~-.\        \-`                 .~
##    //___\\  \ Mooooo!  ///.----..<        \             _ -~
##   //     \\                ///-._ _ _ _ _ _ _{^ - - - - ~
##
###############################################################################


def main():
    import itertools as it

    def normalize_results(duplicate_groups: List[Iterable[str]]) -> List[Tuple[str, str]]:
        return sorted(
            tuple(sorted((f1, f2))) for group in duplicate_groups for f1, f2 in it.combinations(group, 2)
        )

    with open("_results") as f:
        expected_results = [
            set("images/" + fn for fn in line.strip().split(":"))
            for line in f.read().split("\n")
            if line
        ]
        actual_results = detect_duplicates()

    if normalize_results(actual_results) == normalize_results(expected_results):
        print("OK")
    else:
        print("RESULTS DO NOT MATCH")


if __name__ == "__main__":
    main()
