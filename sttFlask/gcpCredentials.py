import os
import json


file_path = "./credentials.json"

credentials_info = {
  "type": "service_account",
  "project_id": "speachtotext-374807",
  "private_key_id": os.environ['PRIVATE_KEY_ID'],
  "client_email": os.environ['CLIENT_EMAIL'],
  "client_id": os.environ['CLIENT_ID'],
  "auth_uri": "https://accounts.google.com/o/oauth2/auth",
  "token_uri": "https://oauth2.googleapis.com/token",
  "auth_provider_x509_cert_url": "https://www.googleapis.com/oauth2/v1/certs",
  "client_x509_cert_url": os.environ['CLIENT_X509_CERT_URL'],
}


def save_credentials():
  private_key = os.environ['PRIVATE_KEY'].replace("\\n", "\n")
  credentials_info["private_key"] = private_key

  with open(file_path, 'w') as f:
    json.dump(credentials_info, f)

def get_credentials_path():
  return file_path[2:]
