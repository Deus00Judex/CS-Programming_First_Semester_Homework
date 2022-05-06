data Optional a = Empty | Present a deriving Show
 
-- a)
mapOptional :: (a -> b) -> Optional a -> Optional b
mapOptional _ Empty = Empty
mapOptional f (Present a) = Present (f a)
 
-- b)
filterOptional :: (a -> Bool) -> Optional a -> Optional a
filterOptional _ Empty = Empty
filterOptional f (Present a) | f a = Present a
                             | otherwise = Empty
 
-- c)
foldOptional :: (a -> b) -> b -> Optional a -> b
foldOptional _ x Empty = x
foldOptional f _ (Present a) = f a
 
-- d)
data Product = Article String Int deriving Show
isHumanEatable :: Product -> Bool
isHumanEatable (Article "Dog Food" _) = False
isHumanEatable _ = True
 
adjustPrice :: Product -> Product
adjustPrice x | p < 1000 = (Article s (p * 2))
              | otherwise = x
              where (Article s p) = x
 
stringify :: Product -> String
stringify (Article s p) = "The article named '" ++ s ++ "' costs " ++ (show p) ++ " Cent."
 
-- e)
filterHumanEatable :: Product -> Optional Product
filterHumanEatable = (filterOptional (\x -> isHumanEatable x)) . Present
 
adjustPriceO :: Optional Product -> Optional Product
adjustPriceO = mapOptional (\x -> adjustPrice x)
 
stringifyO :: Optional Product -> String
stringifyO = foldOptional (\x -> stringify x) "This article is unavailable."
 
toPriceTag :: Product -> String
toPriceTag = stringifyO . adjustPriceO . filterHumanEatable