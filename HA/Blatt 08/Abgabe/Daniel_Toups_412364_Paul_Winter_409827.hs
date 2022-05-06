{-
Abgabe von:
    Daniel Toups 412364
    Paul Winter 409827
-}

--a)
isMatrix :: [[Int ]] -> Bool
isMatrix matrix = partialchecker matrix 0


partialchecker :: [[Int ]] -> Int ->Bool
partialchecker matrix index =
        if index==(length matrix) -1 then True
        else (length(matrix !! index) == length(matrix !! (index+1))) && partialchecker matrix (index+1)


--b)
dimensions :: [[Int]] -> (Int,Int)
dimensions matrix =
        if isMatrix matrix then (length matrix , length(matrix !! 0))
        else (-1,-1)


--c)
isQuadratic :: [[Int]] -> Bool
isQuadratic matrix=
    if (isMatrix matrix)== False then False
    else length matrix == length(matrix !! 0)

--d)
getRow :: [[Int]] ->Int -> [Int]
getRow matrix i =
    if (isMatrix matrix)== False then []
    else matrix !! i

--d)
getCol :: [[Int]] -> Int -> [Int]
getCol matrix i=
    if (isMatrix matrix)== False then []
    else
        getColInt matrix i 0



getColInt :: [[Int]] -> Int -> Int->[Int]
getColInt matrix i row =
    if row == (length matrix) -1 then
        (matrix !! row) !! i :[]
    else
        matrix !! row !! i :getColInt matrix i (row + 1)



traversezeile :: [[Int]] -> Int -> [Int]
traversezeile (x:xs) n      |   n < length x = x !! n : traversezeile xs n
                            |   n >= length x =
traversezeile [] _     = []

traversespalte :: [[Int]] -> Int -> [[Int]]
traversespalte matrix n         | n == length matrix = []
                                | otherwise = traversezeile matrix n : traversespalte matrix (plusone n)
                                    where
                                        plusone :: Int -> Int
                                        plusone x = x + 1

--e)
trav :: [[Int]] -> [[Int]]
trav matrix = traversespalte matrix 0


--g)
multiply :: [[Int]] -> Int -> [[Int]]
multiply (x:xs) lel =
    (multiplyhelper x lel) : (multiply xs lel)
multiply []  = []


multiplyhelper :: [Int] -> Int-> [Int]
multiplyhelper (x:xs) value =
    x*value : (multiplyhelper xs value)
multiplyhelper []  = []
