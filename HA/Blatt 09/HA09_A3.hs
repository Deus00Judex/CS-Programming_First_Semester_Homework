-- a)
data MultTree a = Index a a [MultTree a] | Data a deriving Show
 
t1 :: MultTree Int
t1 = Index 3 42 [Index 3 15 [Data 3, Data 11, Data 12], Index 19 42 [Data 42, Data 23]]
 
 
-- Hilfsfunktion, die die Länge einer Liste zurückgibt
len :: [a] -> Int
len [] = 0
len (x:xs) = 1 + (len xs)
 
-- b)
verzweigungsgrad :: MultTree a -> Int
verzweigungsgrad (Data _) = 0
verzweigungsgrad (Index _ _ xs) = max (len xs) (verzweigungsgrad' xs)
                                  where verzweigungsgrad' [] = 0
                                        verzweigungsgrad' (x:xs) = max (verzweigungsgrad x) (verzweigungsgrad' xs)
 
-- c)
datenListe :: MultTree a -> [a]
datenListe (Data x) = [x]
datenListe (Index _ _ xs) = datenListe' xs
                            where datenListe' [] = []
                                  datenListe' (x:xs) = datenListe x ++ (datenListe' xs)
 
-- d)
-- Hilfsfunktionen maxInTree und minInTree
maxInTree :: MultTree Int -> Int
maxInTree (Data x) = x
maxInTree (Index _ _ xs) = maxInTree' xs
                           where maxInTree' [] = (minBound :: Int)
                                 maxInTree' (x:xs) = max (maxInTree x) (maxInTree' xs)
 
minInTree :: MultTree Int -> Int
minInTree (Data x) = x
minInTree (Index _ _ xs) = minInTree' xs
                           where minInTree' [] = (maxBound :: Int)
                                 minInTree' (x:xs) = min (minInTree x) (minInTree' xs)
 
datenIntervalle :: MultTree Int -> MultTree Int
datenIntervalle (Data x) = (Data x)
datenIntervalle x = (Index (minInTree x) (maxInTree x) (datenIntervalle' xs))
                    where (Index _ _ xs) = x
                          datenIntervalle' [] = []
                          datenIntervalle' (x:xs) = (datenIntervalle x) : (datenIntervalle' xs)
 
-- e)
contains :: (MultTree Int) -> Int -> Bool
contains (Data x) y = x == y
contains (Index l u xs) y | l <= y && u >= y = contains' xs y
                          | otherwise = False
                          where contains' [] _ = False
                                contains' (x:xs) y = (contains x y) || (contains' xs y)