import pandas as pd
import seaborn as sns
from sklearn import tree
from sklearn.metrics import accuracy_score
import matplotlib
matplotlib.use('TkAgg')
import matplotlib.pyplot as plt

# Figures inline and set visualization style
sns.set()


df_train = pd.read_csv('./data/train_transaction.csv')
df_test = pd.read_csv('./data/test_transaction.csv')


print(df_train.head(n=4))


